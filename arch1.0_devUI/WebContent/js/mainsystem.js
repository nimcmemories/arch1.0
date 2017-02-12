var mainSystemObject = {};


mainSystemObject.addMainSystemResponse = function(data){
	sys.console(data);
	
} 
//var mainSystem = $("#mainsystem");
mainSystemObject.addMainSystem = function(){
	sys.console("mainSystemObject.addMainSystem called");
	var formData = sys.getFormJSON("addMainSystem");
	var data = {"method":"POST","formData":formData,"__eventid":2,"dataType":"json","url":"/addMainSystem"};
	sys.AJAXCall(data,mainSystemObject.addMainSystemResponse);
}

 
