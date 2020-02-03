$(".login-form").validate({
  rules: {
    usernum: {
      required: true,
      minlength: 4
    },     
    username: {
      required: true,
      minlength: 1
      //email:true
    },
    age: {
      required: true,
      minlength: 1
    },
    department: {
      required: true,
      minlength: 1,
      //equalTo: "#password"
    }
  },
  //For custom messages
  messages: {
    username:{
      required: "Enter a username",
      minlength: "Enter at least 4 characters"
    }
  },
  errorElement : 'div',
  errorPlacement: function(error, element) {
    var placement = $(element).data('error');
    if (placement) {
      $(placement).append(error)
    } else {
      error.insertAfter(element);
    }
  }
});

