<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Board Read Page</h1>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Board Read Page</h6>
		</div>

		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<div class="panel-body">
						<form role="form" action="/board/register" method="post">
							<div class="form-group">
								<label>Bno</label><input class="form-control" name='bno' value='<c:out value="${board.bno }"/>' readonly="readonly">
							</div>
							<div class="form-group">
								<label>Title</label>
								<input class="form-control" name='title' value='<c:out value="${board.title }"/>' readonly="readonly">
							</div>
							<div class="form-group">
								<label>Text area</label><textarea class="form-control" rows="3" name="content" readonly="readonly">
								<c:out value="${board.content}" /></textarea>
							</div>
							<div class="form-group">
								<label>Writer</label><input class="form-control" name="writer" value='c:out value="${board.writer}" />' readonly="readonly">
							</div>
							<button data-oper='modify' class="btn btn-default">Modify</button>
							<button data-oper='list' class="btn btn-info">List</button>
						</form>
					</div>
				</table>
			</div>
		</div>

<%@include file="../includes/footer.jsp"%>