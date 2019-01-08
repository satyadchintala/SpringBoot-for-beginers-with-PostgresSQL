<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	<div class="container">
	
		<table class="table table-striped">
			<caption>your tasks are </caption>
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is it Done?</th>
					<th>Update a Task</th>
					<th>Delete a Task</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tasksToDo}" var="todo">
					<tr>
						<td>${todo.desc}</td>
						<td><fmt:formatDate value = "${todo.targetDate}" pattern="MM/dd/yyyy"/></td>
						<td>${todo.completed}</td>
						<td><a type="button" class="btn btn-info" href="/update-task?id=${todo.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning" href="/delete-task?id=${todo.id}">Delete</a></td>
					</tr>
				</c:forEach>	
			</tbody>
		
		</table>
		<div>
			<a class="button" href="/add-task">ADD To Do Task</a>
		</div>
	</div>	
<%@ include file="common/footer.jspf" %>