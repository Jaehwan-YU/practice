window.addEventListener("load",function(event){
    var editorTarget = document.querySelector("textarea");
    var parent = editorTarget.parentElement;

    //webEditor를 editorTarget 바로 동생으로 추가
    var webEditor = document.createElement("div"); //로드
    webEditor.style.background = "yellow";

    var request = new XMLHttpRequest();
    request.onload = function(){
        //alert(request.responseText);
        webEditor.innerHTML = request.responseText;
        editorTarget.after(webEditor);
        //webEditor.style.border = editorTarget.style.border;
        //webEditor.style.width = editorTarget.style.width;
        //webEditor.style.height = editorTarget.style.height;

    };
    request.open("GET", "template.html", true);
    request.send();

    //var webEditor = document.querySelector("#web-editor");
   // editorTarget.after(webEditor);
});