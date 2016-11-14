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
indexObject.functionCollapse = function() {
	console.log("output from collapse link function ... nimc");
    var $BOX_PANEL = $(this).closest('.x_panel'),
        $ICON = $(this).find('i'),
        $BOX_CONTENT = $BOX_PANEL.find('.x_content');
    
    // fix for some div with hardcoded fix class
    if ($BOX_PANEL.attr('style')) {
        $BOX_CONTENT.slideToggle(200, function(){
            $BOX_PANEL.removeAttr('style');
        });
    } else {
        $BOX_CONTENT.slideToggle(200); 
        $BOX_PANEL.css('height', 'auto');  
    }

    $ICON.toggleClass('fa-chevron-up fa-chevron-down');
};

indexObject.functionClose =  function () {
    var $BOX_PANEL = $(this).closest('.x_panel');
    $BOX_PANEL.remove();
};
indexObject.f_showEntireDesktop = function(){
	 $("#right_panel").load("pages/dashboard.html");
	 
};
indexObject.f_addSwapEligibility = function(){
	console.log("swap dashboard render event " );
	
	$("#rightPanelDashboard").addClass("flipInX");
	$("#dashboardContent").empty();
	$("#dashboardContent").append(tableaudivs.swapEligibility);
	tableaudivs.f_swapEligibility();
	$("#rightPanelDashboard").removeClass("flipInX");
	$("#"+tableaudivs.swapEligibilityDiv).css("overflow","scroll");
	console.log("swap dashboard render event Complete ..." );
}
