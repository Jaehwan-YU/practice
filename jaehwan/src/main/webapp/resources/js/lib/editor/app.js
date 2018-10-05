window.addEventListener("load", function(event) {
	var editorTarget = document.querySelector("textarea");
	var parent = editorTarget.parentElement;
	var webEditor = document.createElement("div");
	webEditor.style.background = "yellow";

	var ts = window.getComputedStyle(editorTarget, null);
	webEditor.style.width = ts.getPropertyValue("width");
	webEditor.style.height = ts.getPropertyValue("height");
	
	var request = new XMLHttpRequest();
	request.onload = function() {
		webEditor.innerHTML = request.responseText;
		editorTarget.after(webEditor);
		
		var iframe = webEditor.querySelector("iframe");    
		var win = iframe.contentWindow; 
		
		// body.html 가 로드되었을 때
		win.addEventListener("load", function(e){    
			var doc = win.document;
			var body = doc.querySelector("body");
			var toolbar = webEditor.querySelector(".toolbar");
			
			toolbar.onclick = function(e){
				var name = e.target.dataset.name;
				
				switch(name){
					case "bold":
						/*doc.execCommand("bold");*/
						var range = doc.selection.createRange();
						doc.execCommand("insertHTML", false, '<strong>?</strong>');
						break;

					case "color":
						doc.execCommand("foreColor", false, 'rgb(255,0,0)');
						break;

					case "image":
						var fileInput = toolbar.querySelector("input[type='file']");

						var mouseEvent = new MouseEvent("click", {
							view : window,
							bubbles : true,
							cancelable : true
						});

						fileInput.dispatchEvent(mouseEvent);
						fileInput.onchange = function(){

							var file = fileInput.files[0];

							var formData = new FormData();
							formData.append("file",file);


							var request = new XMLHttpRequest();

							request.onload = function(){
								// ??업로드된 사진을 편집 영역에 붙여넣기
								var path = request.responseText;
								var img = doc.createElement('img');
								
								img.src = path;
								
								body.appendChild(img);
							};
							
							request.open("POST", "/jaehwan/academy/upload-ajax", true);
							request.send(formData);

						}

						break;
				}
				
				editorTarget.value = body.innerHTML;
			}
			
			body.onkeyup = function(){
				editorTarget.value = body.innerHTML;
			}
			
		});
	};
	request.open("GET", "template.html", true)
	request.send();
});