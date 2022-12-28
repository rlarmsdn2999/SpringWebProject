<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="container-fluid">

	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="h3 mb-2 text-gray-800">Board Register</h1>
		</div>	
	</div>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Board Register</h6>
		</div>

		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<div class="panel-body">
						<form role="form" action="/board/register" method="post">
							<div class="form-group">
								<label>Title</label><input class="form-control" name="title">
							</div>
							<div class="form-group">
								<label>Text area</label>
								<textarea class="form-control" rows="3" name='content'></textarea>
							</div>
							<div class="form-group">
								<label>Writer</label><input class="form-control" name="writer">
							</div>
							<button type="submit" class="btn btn-default">Submit Button</button>
							<button type="reset" class="btn btn-default">Reset Button</button>
						</form>
					</div>
				</table>
			</div>
		</div>
<%@include file="../includes/footer.jsp"%>