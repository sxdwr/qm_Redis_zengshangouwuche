$(function () {
    load();
    changeTotalPrice();
    //删除商品
    $('.items').on('click','.delete',function () {
        let id = $(this).parent().siblings('.id').text();
        $.ajax({
            type:'post',
            data: {
                id:id
            },
            url:'http://localhost:8080/deleteServlet',
            success:function (res) {
                alert('删除成功');
                load();
            }
        })
    })
    //勾选全部
    $('.checkout').on('click','.check_all',function () {
        $('.items li .check').each(function () {
            $(this).prop('checked',$('.check_all').prop('checked'));

        });
        changeTotalPrice();
    });
    // 勾选单个
    $('.items').on('click','.check',function () {
        changeTotalPrice();
    });
    //增加数量
    $('.items').on('click','.add',function () {
        let amount = $(this).siblings('.amount').prop('value');
        amount++;
        $(this).siblings('.amount').prop('value',amount);
        change(this,amount);
        changeTotalPrice();
    })
    //减少数量
    $('.items').on('click','.del',function () {
        let amount = $(this).siblings('.amount').prop('value');
        amount--;
        if (amount >= 1){
            $(this).siblings('.amount').prop('value',amount);
            change(this,amount);
        }
        changeTotalPrice()
    })
    //直接输入数量
    $('.items').on('blur','input',function () {
        let amount = $(this).val();
        if (amount >= 1){
           change(this,amount);
        }
        changeTotalPrice();
    })
    function updateAmount(id,amount) {
        $.ajax({
            type: 'get',
            url: 'http://localhost:8080/updateServlet',
            data:{
                id:id,
                amount:amount
            },
            success : function (){
                console.log('success');
            }
        })
    }
    //渲染数据
    function load() {
        $.ajax({
            type:'get',
            url:'http://localhost:8080/queryAllServlet',
            success :function (res) {
                $('.shop .items').empty();
                $.each(res,function () {
                    $('.items').prepend('<li>\n' +
                        '                    <i class="id">'+this.iD+'</i>\n' +
                        '                    <input type="checkbox" class="check">\n' +
                        '                    <div class="pic">\n' +
                        '                        <img src='+ this.imageURL+' alt="">\n' +
                        '                        <p class="title">'+this.title+'</p>\n' +
                        '                    </div>\n' +
                        '                    <div class="price">\n' +
                        '                        <span class="o_price"><del>￥'+this.oPrice+'</del></span>\n' +
                        '                        <span class="dis_price">￥'+this.disPrice+'</span>\n' +
                        '                    </div>\n' +
                        '                    <div class="change_item">\n' +
                        '                        <a href="javascript:;" class="del">-</a>\n' +
                        '                        <input type="text" class="amount" value='+this.amount+'>\n' +
                        '                        <a href="javascript:;" class="add">+</a>\n' +
                                                '<span>总价 <b class="xj">￥'+this.amount * this.disPrice +'</b></span>'+
                        '                    </div>\n' +
                        '                    <div class="operator">\n' +
                        '                        <a href="javascript:;" class="delete">删除</a>\n' +
                        '                    </div>\n' +
                        '                </li>');

                });
            }
        });
    }
    //改变数量需要修改的内容
    function change(_this,amount){
        updateAmount($(_this).parent().siblings('.id').text(),amount);
        //修改每一个的总价
        let price = $(_this).parent().siblings('.price').children('.dis_price').text().substring(1);
        $(_this).siblings('span').children('.xj').text(price * amount);
    }
    //修改总价
    function changeTotalPrice() {
        let priceAll = 0;
        let num = 0;
        let flag = false;
        $('.items .check').each(function () {
            if ($(this).prop('checked')){
                let price = $(this).siblings('.change_item').children('span').children('.xj').text();
               if(price[0] === '￥') price = parseInt(price.substring(1));
                priceAll += price;
                num++;
            }
            else {
                flag = true;
            }
        });
        if (flag) $('.check_all').prop('checked','');
        else $('.check_all').prop('checked','checked')

        $('.total_price').text(' ￥'+priceAll.toFixed(2));
    }
})