


//npm install bootstrap
/*
index.js

import 'bootstrap/dist/css/bootstrap.min.css';

*/

export default function Studshow() {
    const students = [
        {
          'id': 11, 
          'name': 'Hardik', 
          'email': 'haridik@gmail.com'
        },
        {
          'id': 22, 
          'name': 'Sanesh', 
          'email': 'sanesh@gmail.com'
        },
        {
          'id': 33, 
          'name': 'Karan', 
          'email': 'karan@gmail.com'
        },
    ];
    return (
        <div>
            <h1>React Map Loop Example</h1>
       
            <table className="table table-striped table-success">
                <thead className="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                </tr>
      </thead>
      <tbody>
         
                {students.map((student2) => (
                  <tr key={student2.id}>{/*//0,1,2*/ }
                    <td>{student2.id}</td>
                    <td>{student2.name}</td>
                    <td>{student2.email}</td>
                  </tr>
                ))}
               </tbody>
         
            </table>
      
        </div>
      );

}

