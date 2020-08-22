
Structure of framework defined:

->com.aj.global 	->  This contains the global super classes which are used for initilazing the
						selenium drivers and pageobject.

->com.aj.po			->	This package contains the page object mapping of the websites

->com.aj.flow		->	This package contains the different operation/flows of that page which we can resuse it in my different testcases also.
						Eg, SearchPage -> searchItem, searchItemAndFindPrice, searchItemAndAddToCart, .. etc

->com.aj.pojo		->	This package is for pojo class

->com.aj.common 	->	This package is for common classes which are used in the most of the classes or every where.
						Eg, TestConstants, CustomWait(selenium explicit wait), ...etc





Driver's Versions:

Chromedriver: 84.0.4147.30

GekoDriver: 0.27.0

IEDriverServer_Win32: 3.150.1 



----------------================-------------

Apart from ProductPriceComparisionTest test class which is main, I have also created ProductPriceComparisionTest_dataprovider test class with little different approch. I have seen that product name and structure are different in different websites. Eg, Amazon :Apple iPhone 11 (64GB) - Black and in Flipkart: Apple iPhone 11 (Black, 128 GB). So in this test class I am passing 3 different parameters ProductName: Apple iPhone 11, ProductSize:64GB, ProductColor: Black. This will reduce the failing chances of the testcases for other products.