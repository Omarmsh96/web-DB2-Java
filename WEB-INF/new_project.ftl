<#include "header.ftl">
	<form method="POST" action="new_project?action=newProject&amp;sessionEmail=${sessionEmail}">
		<fieldset id="makeProject">
			<legend>Required Information</legend>
			<h3>Edit project</h3>
			
			<div>
				<label>Title </label>
				<input type="text" name="title">
		    </div>
	
			<div>
				<label>Funding Limit (in Euro)</label>
				<input type="text" name="fundingLimit">
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
				<textarea rows="5" cols="50" name="description"></textarea>
			</div>
		</fieldset>
		<button href="NewProject" type="submit" id="submitProject">Create</button>
	</form>
<#include "footer.ftl">