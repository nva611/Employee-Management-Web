<form action="insert" method="post">
	<fieldset class="form-group">
		<label>Id</label> <input type="text" class="form-control" name="id"
			required="required">
	</fieldset>
	<fieldset class="form-group">
		<label>Name</label> <input type="text" value="" class="form-control"
			name="name" required="required">
	</fieldset>

	<fieldset class="form-group">
		<label>Sex</label><br>
		<div class="form-control">
			<input type="radio" id="Female" value="0" class="" name="sex">
			<label for="Female">Female</label> <input type="radio" id="Male"
				value="1" class="" name="sex"> <label for="Male">Male</label>
		</div>
	</fieldset>


	<!-- <fieldset class="form-group">
		<label>Birth Date</label>
		<div display="flex" style="border: 1px" class="form-group">
			<label>Date</label> <input type="text" style="width: 80px" class=""
				value="" name="date" required="required"> <label>Month</label>
			<input type="text" style="width: 80px" class="" value="" name="month"
				required="required"> <label>Year</label> <input type="text"
				style="width: 80px" class="" value="" name="year"
				required="required">
		</div>
	</fieldset> -->
	
    <fieldset class="form-group">
        <label>Birth Date</label>
        <div display="flex" style="border: 1px" class="form-group">
            <input type=date style="width: 150px" class=""
                value="" name="bDate" required="required" max="<%= java.time.LocalDate.now() %>">
        </div>
    </fieldset> 
    
	<fieldset class="form-group">
		<label>Home Town</label> <input type="text" value=""
			class="form-control" name="homeTown" required="required">
	</fieldset>

	<fieldset class="form-group">
		<label>Phone</label> <input type="text" value="" class="form-control"
			name="phone">
	</fieldset>

	<fieldset class="form-group">
		<label>Address</label> <input type="text" value=""
			class="form-control" name="address">
	</fieldset>

	<fieldset class="form-group">
		<label>Status</label> <br> <input type="radio" id="Active"
			value="1" class="" name="status"> <label for="Active">Active</label>

		<input type="radio" id="TemporarilyLocked" value="2" class=""
			name="status"> <label for="TemporarilyLocked">Active</label>

		<input type="radio" id="LockedForever" value="3" class=""
			name="status"> <label for="LockedForever">Locked
			forever</label>

	</fieldset>
	<button type="submit" class="btn btn-success">Save</button>


</form>
