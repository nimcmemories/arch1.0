var sys={};
sys.contextPath="./controller";
sys.home = "./";
sys.IS_DEV_MODE=true;
sys.sessionTestJson = {"method":"POST","formData":{"test":"test"},"__eventid":2,"dataType":"json","url":"/ok"};

sys.sessionTestResponse = function(data){
	alert("data from test session : " + JSON.stringify(data));
}
sys.AJAXCall = function(data,responseFunction){
	$.ajax({
		type: data.method,
		url: sys.contextPath+data.url,
		data: data,
		async:	true,
		dataType:'json',
		
        beforeSend : function (){
        	/*if(isLoading!=false)
        		sys.setOverlay();*/
        },
		success: function(responseJson) {
			responseFunction(responseJson);
		},
		error: function (data, status, e){
			console.log("error status : " + data.status + " e : " + e + " error data : " + JSON.stringify());
			
			if(data.status == 409){
				$(location).attr('href', sys.home+"login.html");
			}
		},
		complete : function (){
			//sys.removeOverlay();
        },timeout:30*60*1000
	});		
};
sys.getFormData=function(formId){
	return $("#"+formId+"").serializeArray();
};
sys.getFormJSON = function(formId){
	var jsonData = sys.getFormData(formId);
	var result = { };
	$.each(jsonData,function(){result[this.name] = this.value;});
	return JSON.stringify(result);
};
sys.console = function(message){
	if(sys.IS_DEV_MODE){
		console.log(message);
	}
}
sys.alert = function(message){
	if(sys.IS_DEV_MODE){
		alert(message);
	}
}
/*
 */
