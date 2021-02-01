<#include "header.ftl">

	<form method="POST" action="edit_project?action=editProject&amp;id=${id}&amp;sessionEmail=${sessionEmail}" title="edit Project">
		<fieldset id="editProject">
			<legend>Required Information</legend>
			<h3>Edit project</h3>
			<div>
				<label>Title </label>
				<input type="text" name="title" value=${project.title}>
		    </div>
	
			<div>
				<label>Funding Limit (in Euro)</label>
				<input type="text" name="fundingLimit" value=${project.fundingLimit}>
			</div>
			<div>
				<label onload="myFunction()">Category</label>
				<input type="radio" name="category" value="cat1"> cat1
				<input type="radio" name="category" value="cat2"> cat2<br>
				<input type="radio" name="category" value="cat3"> cat3
				<input type="radio" name="category" value="cat4"> cat4<br>
				
			</div>
			<div>
				<label>parent project: </label>
				<#list createdProjects as cp>
					<input type="radio" name="parent" value="${cp.projectID}">${cp.title}<br>
				</#list>
			</div>
			
			<div>
				<label>description</label>
				<textarea rows="5" cols="50" name="description">${project.description}</textarea>
			</div>
		</fieldset>
		<button type="submit" id="updateProject">Update Project</button>
	</form>
<#include "footer.ftl">