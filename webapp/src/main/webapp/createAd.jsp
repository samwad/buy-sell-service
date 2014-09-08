<html>
<title>Buy Sell App</title>
<body>
<h2>Create an Ad</h2>
<br/>
<form id="createAdForm" method="post" name="createAd" title="Create Ad" action="/createAd">
Price: <input id="price" name="price" type="text" /><br/>
Description: <input id="description" name="description" type="text" /><br/>
timeOfExpiry: <input id="timeOfExpiry" name="timeOfExpiry" type="text" /><br/>
createdBy: <input id="createdBy" name="createdBy" type="text" /><br/>
location: <input id="location" name="location" type="text" /><br/>
contact: <input id="contact" name="contact" type="text" /><br/>
Ad Type: <select name="adType">
<option  value="BUY">BUY</option>
<option value="SELL"/>SELL</option>
<option value="RENTAL"/>RENTAL</option>
</select><br/>
<input type="submit" name="method" value="CREATE" />
</form>
</body>
</html>