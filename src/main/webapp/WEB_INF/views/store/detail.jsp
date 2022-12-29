<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>


<br/>
<br/>

<div class="container">
<div class="row">
<div class="col-lg-8">
<div class="card mb-4">
                        <a href="#!"><img class="card-img-top" src="https://dummyimage.com/850x350/dee2e6/6c757d.jpg" alt="..."></a>
                        <div class="card-body">
                            <div class="small text-muted">January 1, 2022</div>
                            <h2 class="card-title h2">${storeDetail.store.storeName}</h2>
                            <p class="card-text">${storeDetail.store.storeName} </p>
                            <p class="card-text"> </p>
                        </div>
                    </div>

</div> <!-- 왼쪽   -->
<div class="col-lg-4">
					<div class="card mb-4">
                        <div class="card-header">지도</div>
                        <div class="card-body">You can put anything you want inside of these side widgets. They are easy to use, and feature the Bootstrap 5 card component!</div>
                    </div>


</div>




</div> <!-- row  -->

</div>

<%@ include file="../layout/footer.jsp"%>

