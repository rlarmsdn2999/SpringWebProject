<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="../includes/header.jsp"%>

	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">Tables</h1>

		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">Board List Page</h4>
			<button id='regBtn' type="button" class="btn btn-xs pull-right" style="float:right;">Register New Board</button>
		</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>#번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>수정일</th>
							</tr>
						</thead>
						<c:forEach items="${list}" var="board">
						<tr>
							<td><c:out value="${board.bno}" /></td>
							<td><a href='/board/get?bno=<c:out value="${board.bno}"/>'><c:out value="${board.title}"/></a></td>
							<td><c:out value="${board.writer}" /></td>
							<td><fmt:formatDate pattern="yyyy-mm-dd"
									value="${board.regdate}" /></td>
							<td><fmt:formatDate pattern="yyyy-mm-dd"
									value="${board.updateDate}" /></td>
						</tr>
					</c:forEach>
					</table>
				
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">Modal Title</h4>
							</div>
							<div class="modal-body">처리가 완료되었습니다.</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary">Save Changes</button>
							</div>	
						</div>
					</div>
				</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.container-fluid -->
<!-- End of Main Content -->
<script type="text/javascript">
$(document).ready(function(){
	var result = '<c:out value="${result}"/>';
	
	checkModal(result);
	history.replaceState({},null,null);
	function checkModal(result){
		if(result === '' || history.state){
			return;
		}
		if(parseInt(result)>0){
			$(".modal-body").html("게시글 " +parseInt(result)+" 번이 등록되었습니다.");
		}
		$("#myModal").modal("show");
	}
	$("#regBtn").on("click",function(){
		self.location = "/board/register";
	});
	});
</script>
<%@include file="../includes/footer.jsp"%>
