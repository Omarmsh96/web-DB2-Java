<#include "header.ftl">
	<form method="POST" action="view_comment?action=newComment&amp;id=${id}&amp;sessionEmail=${sessionEmail}" title="submit">
		<fieldset id="makeComment">
			<legend>Required Information</legend>
			<h3>${project.title}</h3>
			
			<div>
				<textarea rows="5" cols="50" name ="comment" placeholder="Write a comment"></textarea>
		    </div>
	
			<div>
				<input type="checkbox" name="anonymous" value="true"> anonymous comment?<br>
		    </div>
		</fieldset>
		<input type="hidden" value="${project.creator}" name="projectCreator">
		<button type="submit" id="submitComment">Submit Comment</button>
	</form>
	<#include "footer.ftl">