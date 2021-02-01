<#include "header.ftl">
	<form method="POST" action="new_project_fund?action=newDonation&amp;id=${id}&amp;sessionEmail=${sessionEmail}" title="view_project">
		<fieldset id="makeDonation">
			<legend>Required Information</legend>
			<h3>${project.title}</h3>
			
			<div>
				<label>amount of donation (€): </label>
				<input type="text" name="amount">
		    </div>
	
			<div>
				<input type="checkbox" name="anonymous" value="true"> anonymous donation?<br>
		    </div>
		</fieldset>
		<button type="submit" id="submitDonation">Submit Donation</button>
	</form>
<#include "footer.ftl">