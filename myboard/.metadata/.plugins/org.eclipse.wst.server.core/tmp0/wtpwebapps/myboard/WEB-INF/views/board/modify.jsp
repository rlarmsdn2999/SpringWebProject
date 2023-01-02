<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Scrolling Nav - Start Bootstrap Template</title>
<link rel="icon" type="image/x-icon"
	href="/resources/assets/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/resources/css/styles.css" rel="stylesheet" />
</head>
<body id="page-top">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<div class="container px-4">
			<a class="navbar-brand" href="#page-top">Start Bootstrap</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link" href="#about">About</a></li>
					<li class="nav-item"><a class="nav-link" href="#services">Services</a></li>
					<li class="nav-item"><a class="nav-link" href="#contact">Contact</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Header-->
	<header class="bg-primary bg-gradient text-white">
		<div class="container px-4 text-center">
			<h1 class="fw-bolder">Board Modify</h1>
		</div>
	</header>
	<!-- About section-->
	<div class="container px-4">
		<div class="row gx-4 justify-content-center">
			<div class="col-lg-8">
				<h2>게시글 조회</h2>
				<table class="table table-hover">
					<div class="panel-body">
						<form role="form" action="/board/modify" method="post">
						<input type="hidden" id="pageNum" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
						<input type="hidden" id="amount" name="amount" value='<c:out value="${cri.amount}"/>'>
						<input type="hidden" id="pageNum" name="type" value='<c:out value="${cri.type}"/>'>
						<input type="hidden" id="amount" name="keyword" value='<c:out value="${cri.keyword}"/>'>
							<div class="form-group">
								<label>번호</label><input class="form-control" name='bno' value='<c:out value="${board.bno }"/>' readonly="readonly">
							</div>
							<div class="form-group">
								<label>제목</label>
								<input class="form-control" name='title' value='<c:out value="${board.title }"/>'>
							</div>
							<div class="form-group">
								<label>내용</label><textarea class="form-control" rows="3" name="content" ><c:out value="${board.content}" /></textarea>
							</div>
							<div class="form-group">
								<label>작성자</label><input class="form-control" name="writer" value='<c:out value="${board.writer }"/>' readonly="readonly">
							</div>
							<div class="form-group">
								<label>작성날짜</label>
								<input class="form-control" name="regDate" value='<fmt:formatDate pattern="yyyy/mm/dd" value="${board.regdate}"/>' readonly="readonly">
							</div>
							<button type="submit" data-oper="modify" class="btn btn-default">수정</button>
							<button type="submit" data-oper="remove" class="btn btn-danger">삭제</button>
							<button type="submit" data-oper="list" class="btn btn-info">목록</button>
						</form>
					</div>
				</table>
			</div>
		</div>
	</div>
	<!-- Footer-->
	<footer class="py-5 bg-dark">
		<div class="container px-4">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2022</p>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="/resources/js/scripts.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var formObj = $("form");
		$('button').on("click",function(e){
			e.preventDefault();
			var operation=$(this).data("oper");
			console.log(operation);
			
			if(operation ==='remove'){
				formObj.attr("action","/board/remove");
			}
			else if(operation === 'list'){
				formObj.attr("action", "/board/list").attr("method","get");
				var pageNumTag=$("input[name='pageNum']").clone();
				var amountTag=$("input[name='amount']").clone();
				var typeTag=$("input[name='type']").clone();
				var keywordTag=$("input[name='keyword']").clone();
				formObj.empty();
				formObj.append(pageNumTag);
				formObj.append(amountTag);
				formObj.append(typeTag);
				formObj.append(keywordTag);
			}
			formObj.submit();
		});
	});
</script>
</body>
</html>
