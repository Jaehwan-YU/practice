insert into memberrole(memberId, roleName) values('sora','ROLE_STUDENT')
select*from memberrole
select*from member
select memberId id, roleName authority from MemberRole where memberId=?