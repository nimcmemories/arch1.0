var tableaudivs = {};
tableaudivs.swapEligibilityDiv = "viz1479081586324";
tableaudivs.swapEligibility = "<div class='tableauPlaceholder' id='viz1479081586324' style='overflow: scroll;position: relative'><noscript><a href='https:&#47;&#47;www.infowetrust.com&#47;endangeredsafari'><img alt='ENDANGERED SAFARI ' src='https:&#47;&#47;public.tableau.com&#47;static&#47;images&#47;28&#47;28P593TSR&#47;1_rss.png' style='border: none' /></a></noscript><object class='tableauViz'  style='display:none;'><param name='host_url' value='https%3A%2F%2Fpublic.tableau.com%2F' /> <param name='path' value='shared&#47;28P593TSR' /> <param name='toolbar' value='yes' /><param name='static_image' value='https:&#47;&#47;public.tableau.com&#47;static&#47;images&#47;28&#47;28P593TSR&#47;1.png' /> <param name='animate_transition' value='yes' /><param name='display_static_image' value='yes' /><param name='display_spinner' value='yes' /><param name='display_overlay' value='yes' /><param name='display_count' value='yes' /><param name='tabs' value='no' /></object></div> ";
tableaudivs.f_swapEligibility = function(){
	var divElement = document.getElementById('viz1479081586324');
    	var vizElement = divElement.getElementsByTagName('object')[0];    
    	vizElement.style.width='1204px';vizElement.style.height='869px';  
    	var scriptElement = document.createElement('script');             
    	scriptElement.src = 'https://public.tableau.com/javascripts/api/viz_v1.js';          
    	vizElement.parentNode.insertBefore(scriptElement, vizElement);
    	console.log("tableau function called ");
};