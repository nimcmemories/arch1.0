var login = {};

login.responseOfTestHelper = function(data){
	/*
	 * method will redirect to index.html on success
	 */
	$(location).attr('href', sys.home+"index.html");
}
var working = false;
$('.login').on('submit', function(e) {
  e.preventDefault();
  if (working) return;
  working = true;
  var $this = $(this),
    $state = $this.find('button > .state');
  
  $this.addClass('loading');
  $state.html('Authenticating');
  var formId = "login";
  var data = JSON.stringify(sys.getFormJSON(formId));
  alert("data : login.js from form params : " + JSON.stringify(data));
  var JsonData = {"method":"POST","formData":data,"__eventid":2,"dataType":"json","url":"/auth"};
  sys.AJAXCall(JsonData, login.responseOfTestHelper);
  setTimeout(function() {
    $this.addClass('ok');
    $state.html('Welcome back!');
    setTimeout(function() {
      $state.html('Log in');
      $this.removeClass('ok loading');
      working = false;
    }, 4000);
  }, 3000);
});