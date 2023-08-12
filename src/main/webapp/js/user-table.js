// khi nao trang html noi dung dc nap vao trinh duyet
//thi se chay code trong function
$(document).ready(function(){
//lang nghe su kien click cho the co id la btn-delete-user
    $(".btn-delete-user").click(function(){
        var id=$(this).attr("userid")
        var This=$(this);
        $.ajax({
            method:"GET",
            url:"http://localhost:8080/demoservlet/user/delete?id="+id,
//            data:{}
        }).done(function(result){
        This.closest("tr").remove();
//        console.log("Ket qua",result)
        })
    })
    $(".btn-detail-user").click(function(){
            var id=$(this).attr("userid")
            var This=$(this);
            $.ajax({
                method:"GET",
                url:"http://localhost:8080/demoservlet/user/detail/"+id,
    //            data:{}
            }).done(function(result){
                  window.location.href = "http://localhost:8080/demoservlet/user/detail/"+id;

            })
        })
})