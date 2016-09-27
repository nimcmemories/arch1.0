var login = {};

login.responseOfTestHelper = function(data){
	alert(data);
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
  var data = "nimesh";
  var JsonData = {"method":"POST","formData":data,"__eventid":2,"dataType":"json","url":""};
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