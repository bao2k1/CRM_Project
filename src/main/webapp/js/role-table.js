$(document).ready(function(){
//lang nghe su kien click cho the co id la btn-delete-user
    $(".btn-delete-role").click(function(){
        var id=$(this).attr("roleid")
        var This=$(this);
        $.ajax({
            method:"GET",
            url:"http://localhost:8080/demoservlet/role/delete?id="+id,
//            data:{}
        }).done(function(result){
        This.closest("tr").remove();
        console.log("Ket qua",result)
        })
    })
})