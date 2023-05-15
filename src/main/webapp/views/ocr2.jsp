<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://fonts.googleapis.com/css2?family=Bitter:wght@600&family=Nanum+Myeongjo:wght@800&display=swap"
      rel="stylesheet">
<script>

    let ocr1 = {
        init: function () {
            $("#ocr1_btn").click(function () {
                ocr1.send(); // this.send() 안됨! 유의
            });
        },
        // 서버로 보내기
        send: function () {
            $("#ocr1_form").attr({
                'action': '/ocr1impl',
                'method': 'post'
            });
            $("#ocr1_form").submit();
        }
    };
    // web04 - webapp - views = login.jsp

    // 화면 로딩
    $(function () {
        ocr1.init();
    });
</script>


<style>

</style>
<div class="col-sm-8 text-left">
    <div class="container">
        <div class="row content">
            <div class="col-sm-6 text-left">
                <div>
                    <h2 style="text-align: center">OCR 1 </h2>
                </div>
                <br><br><br>

                <form class="form-horizontal" id="ocr1_form" action="/ocr1impl" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="img">Image:</label>
                        <div class="col-sm-10">
                            <input type="file" class="form-control" id="img" placeholder="Upload your image" name="img">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="button" id="ocr1_btn" class="btn btn-primary">upload</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-sm-8 text-left">
                <table class="table">
                    <thead>
                    <tr>
                        <th>항목</th>
                        <th>판독결과</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>사업자 등록번호</td>
                        <td>${result.biznum}</td>
                    </tr>
                    <tr class="success">
                        <td>사업자명</td>
                        <td>${result.bizname}</td>
                    </tr>
                    <tr class="danger">
                        <td>사업자 개업날짜</td>
                        <td>${result.bizdate}</td>
                    </tr>
                    <tr class="info">
                        <td>사업자 주  소</td>
                        <td>${result.bizadd}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>