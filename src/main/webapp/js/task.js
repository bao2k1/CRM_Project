$(document).ready(function(){
//lang nghe su kien click cho the co id la btn-delete-task
    $(".btn-delete-task").click(function(){
        var id=$(this).attr("taskid")
        var This=$(this);
        $.ajax({
            method:"GET",
            url:"http://localhost:8080/demoservlet/task/delete?id="+id,
//            data:{}
        }).done(function(result){
        This.closest("tr").remove();
        console.log("Ket qua",result)
        })
    })
})