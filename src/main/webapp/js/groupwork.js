$(document).ready(function(){
//lang nghe su kien click cho the co id la btn-delete-user
    $(".btn-delete-job").click(function(){
        var id=$(this).attr("jobid")
        var This=$(this);

        $.ajax({
            method:"GET",
            url:"http://localhost:8080/demoservlet/groupwork/delete?id="+id,
//            data:{}
        }).done(function(result){
        This.closest("tr").remove();
        console.log("Ket qua",result)
        })
    })
})