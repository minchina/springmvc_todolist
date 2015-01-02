$(window).ready(function(){
    var THIS = $('#new-todo');
    THIS.keydown(function(e){
        if(e.keyCode==13){
            var name = THIS.val();
            var user_id = $("#user_id").val();
            $.ajax({
                url:"/todo/add",
                data:{name:name,user_id:user_id},
                type:"POST",
                success:function(json_todo){
                    var todo = JSON.parse(json_todo);
                    var target = $("#todo-list");
                    target.append(concatString(todo.id,todo.name));
                    THIS.val("");
                }
            })
        }
    });

    $(".destroy").on("click",function(){
        var $li = $(this).closest("li");
        var user_id = $li.data().id;
        $.ajax({
            url:"/todo/delete",
            data:{id:user_id},
            type:"POST",
            success:function(){
                $li.remove();
            }
        })

    });

    $(".toggle").on("click",function(){
        var $check_box = $(this);
        post_update($check_box);
    });



    $("label").on("dblclick",function(){
        var $input = $(this).closest("li").addClass("editing").find('.edit');
        $input.val($input.val()).focus();
    });

    $(".edit").on("focusout",function(){
        var name = $(this).val();
        var $li = $(this).closest("li");
        var data_id = $li.data("id");
        var $label = $li.find("label");
        var $check_box = $li.find(".toggle");
        console.log(data_id,name,is_checked($check_box));
        $.ajax({
            url:"/todolist_v1/update",
            data:{id:data_id,name:name,status:is_checked($check_box)},
            type:"POST",
            success:function(){
                $label.text(name);
                $li.removeClass("editing");
            }
        });
    });
    function concatString(id,name){
        var expectString =
            "<li data-id="+id+">"+
            "<div class='view'>"+
            "<input class='toggle' type='checkbox'>"+
            "<label>"+ name +"</label>"+
            "<button class='destroy'></button>"+
            "</div>"+
            "<input class='edit' value='123'>"+
            "</li>";
        return expectString;
    }

    function post_update($check_box){
        var $li = $check_box.closest("li");
        var data_id = $li.data("id");
        var name = $li.find(".edit").val();
        $.ajax({
            url:"/todolist_v1/update",
            data:{id:data_id,name:name,status:is_checked($check_box)},
            type:"POST",
            success:function(){
                $check_box.closest("li").toggleClass("completed");
            }
        })
    }

    function is_checked($check_box){
        if($check_box.prop("checked")){
            return 1
        }
        return 0;

    }
});
