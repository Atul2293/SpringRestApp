GraphQL :
==========

Originally built by Facebook, GraphQL is a query language for APIs that lets developers
choose the types of requests they want to make and receive the information they require
in a single request.

Here are the key benefits GraphQL offers developers:
1. Declare exactly what they need from the server and receive the requested data in a
   predictable way.
2. Retrieve many resources from the server in a single request.
3. It’s strongly typed i.e. it allows API users to know (1) what data is available and
   (2) what form it exists in.

   With GraphQL, the shape of the data that’s returned depends entirely on the client’s
   query. As a result, additional fields can easily be added to the server
   (for example, when adding new product features) without affecting existing clients.
   This works the other way around, as well. So, when you’re sunsetting older features,
   the corresponding server fields will continue to function even if they’re deprecated. In this way, GraphQL brings about a backward-compatible process that eliminates the need for incrementing version numbers.


       POST :  http://{{host}}:{{port}}/graphql/cricket
       Body :
       1. To get all Teams :
       {
                   allTeam {
                       id
                       name
                  players{
                       name
                       }
                   }
       }

       2. To get all Players :
         {
            allPlayers{
                 name
                 num
                 position
                     }
         }


       3. To get Team by Team id :
       {
                getTeamById(teamId : 2){
                              id
                              name
                              players{
                              name
                              }
                          }
       }

       4. To add new team :
       {
         saveTeam(teamName : "NewTeamName"){
                              id
                              name
                              players{
                              name
                               }
         }

       }
