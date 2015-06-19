function saveChanges(value)
{
	var personalInfo = [];

	personalInfo.push(document.getElementById('lastName').value);

	personalInfo.push(document.getElementById('firstName').value);

	personalInfo.push(document.getElementById('middleName').value);

	personalInfo.push(document.getElementById('datepicker_birth').value);

	personalInfo.push(document.getElementById('datepicker_death').value);

	personalInfo.push(document.getElementById('placeOfBirth').value);

	personalInfo.push(document.getElementById('currentAddress').value);

	personalInfo.push(document.getElementById('placeOfDeath').value);

	return personalInfo;
}

