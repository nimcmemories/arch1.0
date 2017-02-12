var indexObject = {};
indexObject.listMainSystem = function(){
	var mainSystem = $("#mainsystem");
	mainSystem.click(function(){
		$("#right_panel").load("pages/mainsystem.html")
	});
	
}
 
