# GraphQL MasterClass 
*by keywer*

In this MasterClass we will see the basic component of GraphQL

## Query
GraphiQL url => http://localhost:8080/graphiql

Query:  
```
query{
  mostExpensiveFish {
    id,
    name,
    family {
      id,
      waterType
    }
  }
}
```

Query with parameter:  
```
query{
 fishByName(name:"Discus") {
   id,
  name
 }
}
```

Query with pagination:
```
query{
 findFishWithPagination(pagination: { first: 2,offset: 1}) {
  id,
  name
 }
}
```

Query with cursor:
```
query{
 findFishWithCursor(pagination: { first: 2,after: 3}) {
  id,
  name
 }
}
```

## Java Client
## Mutation
## Exceptions
## Subscription

