var indexObject = {};
indexObject.okformId = "okForm";
indexObject.aclList = "";
indexObject.aclLinkList = "";
indexObject.okFormResponseHandler = function(data){
	console.log("Post login fetch uer info and acl : " + JSON.stringify(data));
	indexObject.userInfo = data;
	indexObject.aclList = indexObject.userInfo["responseInfo"]["responseInfo"]["userACL"];
	indexObject.aclLinkList = indexObject.userInfo["responseInfo"]["responseInfo"]["userLinkACL"];
	$("#indx_username").text(indexObject.userInfo["username"]);
	$("#indx_spn_username").text(indexObject.userInfo["username"]);
}
indexObject.data = JSON.stringify(sys.getFormJSON(indexObject.okformId));
var JsonData = {"method":"POST","formData":indexObject.data,"__eventid":2,"dataType":"json","url":"/ok"};

