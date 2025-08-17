import logo from './logo.svg';
import './App.css';


import React, { useState } from 'react';

import Customerinfo from './REACTFILES/Customer';
import ClassDemo1 from './REACTFILES/ClassComponentDemo1';
import Products from './REACTFILES/Product';
import CollegeList from './REACTFILES/CollegeListNestedMap';
import Studshow from './REACTFILES/REACTBootStrapDemo';


/*
C:\Users\Administrator>node -v
v14.21.3

C:\Users\Administrator>npm -v
6.14.13

C:\Users\Administrator>npm list --depth=0
C:\Users\Administrator
`-- express@4.18.2

npm ERR! extraneous: ms@2.1.3 C:\Users\Administrator\node_modules\send\node_modules\ms

C:\Users\Administrator>npm list -g --depth=0
C:\Users\Administrator\AppData\Roaming\npm
+-- @angular/cli@14.2.13
+-- create-react-app@5.1.0
+-- express@4.18.2
+-- express-generator@4.16.1
+-- json-server@0.17.4
+-- mongodb@6.3.0
+-- mongoose@8.0.3
+-- nodemon@3.1.10
`-- npm@6.14.13


C:\Users\Administrator>npx create-react-app wiproreactdemos2025
*/
//entry point
/*
*/
class Student {
  constructor(name, age) //local argument
  {
    this.n = name;  //n and a is a class variable 
    this.a = age;
  }
  display() {
    console.log("The Name of the student is: ", this.n)
    console.log("The Age of the student is: ", this.a)
  }
}//closing the class


class Car {
  constructor(name) {
    this.brand = name;//BRAND IS A CLASS VARIABLE
  }
  dis() {
    return 'I have a ' + this.brand;
  }
}
/*
Super() function is to call the constructor of the parent class.
 It is used when we need to access a few variables in the parent class.
*/
class Model extends Car {
  constructor(name, mod) {
    super(name);//calling the super class constructor
    this.model = mod;//derived class variable
  }
  show() {
    //this.dis() => parent class method
    return this.dis() + ', it is a ' + this.model
  }
}

//non arrow function
function sayHello() {
  window.alert('Hello!');
}

/*
//FUNCTIONAL COMPONENT::::

Always start component names with a capital letter. 
React treats components starting with lowercase letters 
as DOM tags. 
For example, <div /> represents an HTML div tag,
 but <Employee /> represents a component. 
*/
//functional component
function Show() {
  return <h2>React Training</h2>;
}//<Show />

//Arrow functional component
const Display3 = () => { return <h1>Iam arrow function</h1>; }

/*
Below one is a non-functional component!(NO RETURN KEYWORD,NO CAMELCASE)
 */

const greetAlert = (name) => {

  alert(`Say hello to , ${name}!`);

};
//non-arrow functional component
function Employee(props11) //data1 is a properties or props//They are read-only (cannot be changed inside Employee).
{
  return <div><p>Name : {props11.name}</p>
    <p>Salary : {props11.salary}</p></div>;
}

//arrow functional component
const Department_demo = (deptInfo) => {
  return <div><p>Dept Name is : <b>{deptInfo.dept}</b></p>
    <p>Dept Head is : <b>{deptInfo.head}</b></p></div>;
}

//one functional component reused by another  functional component
//DI Mechanism
//arrow functional component


const Employeeinfo = (data12) => {
  return (<div><p>Name : {data12.name}</p>
    <p>Salary : {data12.salary}</p>
    <Department_demo dept={data12.dept1} head={data12.head1} /></div>);
//<Department_demo dept="HR" head="XYZ" /></div>);
}
/*
useState = allows functional components to remember values across renders.
--This is a way to “preserve” some values between the function calls 
--Should have an initial value. 
The initial value can be got from a parent component  
--Read and write
--Only the component that owns state can change it.
 State is private
--Make the component interactive for users  
--Is also responsible for fetching remote data
--We can pass state as props to child components within 
the render method of the parent component
--Requires in higher-order components
*/
function Example_1() 
{
  const a = 100;//a is a functional component stateless variable

  //first counters variable,The second returned item is itself a function. 

  const [counters, mysetCounter] = React.useState(100);//100 is the default value,counters is the stateful variable
  const [name, setName] = useState("Thananya");
  const [salary, setSalary] = useState(25000);
  //Always use the updater function (setSalary,setName,mysetCounter) — never modify state directly.
  return (
    <div>
  <p>You clicked {counters} times</p>
            <button onClick={() => mysetCounter(counters + 2)}>
        Click me
      </button>
      <h3>Employee Details</h3>
      <p>Name: {name}</p>
      <p>Salary: ₹{salary}</p>
      <button onClick={() => setSalary(salary + 1000)}>Give Raise</button>
      <button onClick={() => setName("Abi")}>Change Name</button>
    </div>
    );
}

function Example_2() 
{
 // Declare a new state variable, which we'll call "mood"
  /*
  mood->Stateful variable
  changeMood->Stateful function
  */
  var [mood, changeMood] = useState('Calm');//default mood="Calm"
  return (
    <div>
      <p>You feel {mood}</p>
       <button onClick={() => changeMood(mood = 'Cheerful')}>
        Click me
      </button>
    </div>
  );
}

//Instead of defaultProps, you can use default parameter values:
//Default parameters (function({prop="value"})) → Common in functional components.
function StaffComponent({ staffName = "Thananya", age = 28,location="chennai" }) {
  return <div>{staffName}, Location: {location},
    Age: {age}</div>
}
/*
Default props can be used to define any props that you want to be set
 for a component, whether or not a value is actually passed in from the parent component.*/
//default properties

/*StaffComponent.defaultProps =
{
  staffName: "Abi",
  location: "Chennai",
  age: "50"
}*/

const employeesdata = [
  { EId: 101, Name: 'Devi', Location: 'Bangalore', Salary: 34004 },
  { EId: 102, Name: 'Thananya', Location: 'Chennai', Salary: 43999 },
  { EId: 103, Name: 'Kanishka', Location: 'Bangalore', Salary: 41994 }
];
/*
If you use { } (curly braces) → you must use return.
If you use ( ) (parentheses) → React will implicitly return the JSX.
No return keyword needed.

If you write multiple statements (logic, variables, conditions, etc.), you need {} and return.

If your component directly returns JSX, you can skip return and {}.
*/
const ComplexList = () => (
  <ol>
    {
      employeesdata.map(item11 => (
        <li key={item11.EId}>
          <div>{item11.Name}</div>
          <div>{item11.Location}</div>
          <div>{item11.Salary}</div>
        </li>
      ))}
  </ol>
);

function StudentList() {
  const students = ["Thananya", "Sara", "Abi", "Devi"];

  return (
    <div>
      <h2>Students:</h2>
      <ul>
        {students.map((name) => (
          <li>{name}</li>  // No key used But React loses efficiency during re-rendering.
//          In bigger apps, this may cause bugs or slow performance.
        ))}
      </ul>
    </div>
  );
}

function Employeeshow(props) {
  return <div style={{ border: "3px dotted green" }}>
    <p>Employee ID : <b>{props.data11.EId}</b></p>

    <p>Employee Name : <b>{props.data11.Name}</b></p>

    <p>Employee Location : <b>{props.data11.Location}</b></p>

    <p>Employee Salary : <b>{props.data11.Salary}</b></p>
  </div>;
}
//for each loop(map)
//FUNCTIONAL COMPONENT
function DispEmp(props) {
  const list = props.employeeList;//tag attribute name
  const listElements = list.map((emp31) =>
    //key and data attributes are map function
    <Employeeshow key={emp31.EId} data11={emp31} />//3 TIMES
  );
  return (
    <div>
          {listElements}{/*3 RECORDS*/ }
    </div>
  );
}

//Presentational component
function School({ name, location, strength }) {
  return (
    <div style={{ border: "1px solid gray", margin: "10px", padding: "10px" }}>
      <h3>{name}</h3>
      <p>Location: {location}</p>
      <p>Students Strength: {strength}</p>
    </div>
  );
}

//Container component (manages array + uses map() to render multiple School).
function SchoolList() {
  const schools = [
    { id: 1, name: "ZION Public School", location: "Chennai", strength: 1200 },
    { id: 2, name: "ALWIN Valley School", location: "Bangalore", strength: 900 },
    { id: 3, name: "ROSE Carmel School", location: "Delhi", strength: 1500 }
  ];
  return (
    <div>
      <h2>School List</h2>
      {
          schools.map((s) => (
            <School key={s.id}  name={s.name}    location={s.location}   strength={s.strength} />
        ))}
      </div>
    );
  }
//ENTRY POINT
function App() {
  var i = 5;
  var stuObj = new Student('Devi', 20);
  let s1 = new Student("John", 21);  
  //const mycar = new Model("Hyundai", "Creta"); //valid
  var mycar = new Model("Hyundai", "Creta"); //valid

  return (
    
    <div className="App">
     <h1>Hello ReactJS-!! !</h1>
      <h1>{20 + 20}</h1>
      <h1>{i == 1 ? 'True!' : 'False!'}</h1>
{/*
     JSX COMMENT LINE!
  */}
 <h1>{stuObj.n}</h1>
      <h1>{stuObj.a}</h1>
      <h1>{stuObj.display()}</h1>
      <h1>{mycar.show()}</h1>
{/*
      <button onClick={sayHello}>Click me!</button>
      If you write onClick={sayHello()} with parentheses, it will call the function immediately when the component renders, instead of when clicked.
  */}
   <Show />
      <Display3 />
      <button onClick={() => { greetAlert("Thananya"); }}>Greet Button</button>
 {/*
     Inline function
  */}
  
  <button onClick={() => alert("Welcome to the world of Programming!")}>Greetings Button</button>
  <Employee name="Thananya" salary="81000" />
  <Employeeinfo name="Kanishka" salary="89000" dept1="Testing" head1="Sai" />

  <Example_1/>

<Example_2/>
  
<Customerinfo cusname="Devi" cusloc="Chennai" f_pt1="100" f_pt2="80" />
<ClassDemo1/>

<Products pid="1001" pname="Laptop" pcost="98000"
        wid111="10" wname111="ACER MALL" wlocation111="Bangalore" />
        {/* Both props and state initial values received 
 from parents ""override default values""" defined inside a 
 Component.  */ }

   <StaffComponent staffName="Devi" />
      <StaffComponent />
      <ComplexList/>
      <StudentList/>
      <DispEmp employeeList={employeesdata}></DispEmp>
<SchoolList/>

<CollegeList/>
<Studshow />


    </div>
  );
}

export default App;
