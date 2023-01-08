$(function () {
    $('.add_btn').on('click',function () {
        let imageURL = $(this).siblings('.pro_img').children('img').prop('src');
        let title = $(this).siblings('.pro_name').children().text();
        let disPrice = $(this).siblings('.pro_price').text();
        disPrice = disPrice.substring(0,disPrice.length - 1);
        let oPrice = disPrice * 1.5;
        let amount = 1;
        let id = Math.floor(Math.random() * 1000);
        $.ajax({
            type: 'post',
            data :{
                imageURL:imageURL,
                title:title,
                disPrice:disPrice,
                oPrice:oPrice,
                amount:amount,
                id:id
            },
            url:'http://localhost:8080/addCartServlet',
            success:function (res) {
                alert("添加成功");
            }
        })

    })
})