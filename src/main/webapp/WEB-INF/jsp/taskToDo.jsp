<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	<div class="container">
		ADD Task To Do For ${name}
		<form:form method="post" modelAttribute="taskToDo">
			<form:hidden path="id"/>
			<fieldset class="form-group">
				<form:label path="description">Description: </form:label>
				<form:input path="description" type="text" class="form-control" required="required" />
				<form:errors path="description" cssClass="text-warning"/>
				<br/>
				<form:label path="targetDate">Target Date: </form:label>
				<form:input path="targetDate" type="text" class="form-control" required="required" />
				<form:errors path="targetDate" cssClass="text-warning"/>
			</fieldset>
			<button type="submit" class="btn btn-success">ADD</button>
		</form:form>
	</div>
<%@ include file="common/footer.jspf" %>