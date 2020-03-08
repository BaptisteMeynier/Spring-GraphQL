# GraphQL MasterClass 
*by keywer*

In this MasterClass we will see the basic component of GraphQL

## Query
GraphiQL url => http://localhost:8080/graphiql

### Query:  
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

### Query with parameter:  
```
query{
 fishByName(name:"Discus") {
   id,
  name
 }
}
```

### Query with pagination:
```
query{
 findFishWithPagination(pagination: { first: 2,offset: 1}) {
  id,
  name
 }
}
```

### Query with cursor:
```
query{
 findFishWithCursor(pagination: { first: 2,after: 3}) {
  id,
  name
 }
}
```

### Query with Fragment:
```
fragment entity on Fish {
 id,
 name
}

query{
 findFishWithCursor(pagination: { first: 2,after: 3}) {
  ...entity
 }
}
```
### Query with variables:
```
query Fish($name: String){
 fishByName(name: $name) {
  id,
  name
 }
}
Query variables
{"name": "Discus"}
```

### We had forget to talk about:
 - scalar => https://graphql.org/learn/schema/#scalar-types
 - union => https://graphql.org/learn/schema/#union-types
 - heritage => https://graphql.org/learn/schema/#interfaces

## Java Client
## Mutation
``` 
mutation {
  createFamily(name:"AFamily",waterType:SEA){
    id,
    name
  }
}
```
## Exceptions
## Subscription

