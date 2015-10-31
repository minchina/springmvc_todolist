$(document).ready(function(){

    var add_user_url = "/users/add";
    var delete_user_url = "/users/delete";

   var $name_input = $('#new-todo');
   $name_input.keydown(function(e){
      if(e.keyCode==13){
         var user_name = $name_input.val();
          httpService(add_user_url,{user_name:user_name}, addUserSuccessCallback);
      }
   });

    $(".destroy").on("click",function(){
        var $li = $(this).closest("li");
        var user_id = $li.data("id");
        httpService(delete_user_url, {user_id:user_id}, deleteUserCallback($li));
    });

    function addUserSuccessCallback(json_user){
        var user = json_user;
        var $user_list = $("#todo-list");
        $user_list.append(concatString(user.name,user.id));
        $name_input.val("");
    }

    function deleteUserCallback (event) {
        event.remove();
    }

   function concatString(user_name,user_id){
      var expectString =
        "<li data-id="+user_id+">"+
            "<div class='view'>"+
            "<a href='users/"+user_name+"/todos'>"+user_name+"</a>"+
            '<button class="destroy"></button>'+
            "</div>"+
        "</li>";
      return expectString;
   }

    function httpService (url,data,callback) {
        $.ajax({
            url:url,
            data:data,
            type:"POST",
            success:callback
        })
    }
});
