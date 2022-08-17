Assumptions 

1. Considering the High price for a day to calculate profit. 
2. Sample endpoint http://localhost:8080/stock/maxProfit?stockSymbol=AMC 
3. I have gathered data from both 3rd parties APIs like Alpha Vantage and NASDAQ. -> The problem with Alpha Vantage is, it returns data worth 100 days. There is no way to get data for just 90 days. So we can get the data from Alpha Vantage and remove the last 10 days' worth of data but it is not an optimal solution.
4. NASDAQ API returns 404 when the wrong stock ticker is passed. Returning that back with a message to the client. In other cases like wrong API key, data_code, or wrong format request, NASDAQ API returns 400 but since it is just for internal use, logging it and returning 500 to the client.
5. If max profit is not possible because of the continously decresing price, returning message - "Max profit is not possible as price is declining with dataset provided" response code 200.
6. Using Lombok to generate Getter, Setter, and for the constructor.
7. Using GSON for passing through JSON.