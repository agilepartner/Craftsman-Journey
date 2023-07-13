KATA=$1

dotnet new sln -o $KATA
cd $KATA
dotnet new classlib -o $KATA
dotnet sln add ./$KATA/$KATA.csproj
dotnet new xunit -o $KATA.Tests
dotnet add ./$KATA.Tests/$KATA.Tests.csproj reference ./$KATA/$KATA.csproj
dotnet sln add ./$KATA.Tests/$KATA.Tests.csproj