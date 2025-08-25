function CollegeList()
 {
    //NESTED ARRAY OF JSON
    const colleges = [
      {
        id: 1,
        name: "SRM Engineering College",
        location: "Chennai",
        departments: [
          {
            id: 101,
            name: "Computer Science",
            courses: ["C Programming", "Data Structures", "ReactJS"]
          },
          {
            id: 102,
            name: "Electronics",
            courses: ["Digital Circuits", "Microprocessors", "VLSI Design"]
          }
        ]
      },
      {
        id: 2,
        name: "MOB Arts & Science College",
        location: "Chennai",
        departments: [
          {
            id: 201,
            name: "Commerce",
            courses: ["Accounting", "Taxation", "Business Law"]
          },
          {
            id: 202,
            name: "English",
            courses: ["Poetry", "Drama", "Linguistics"]
          }
        ]
      }
    ];
    return (
        <div>
    
    <h2>Colleges</h2>
    {colleges.map((college) => (
        <div key={college.id} style={{ border: "2px solid cornflowerblue", margin: "10px", padding: "10px" }}>
        <h3>{college.name}</h3>
        <p>Location: {college.location}</p>

                  {/* Departments */}
        <h4>Departments:</h4>
         {college.departments.map((dept) => (
             <div key={dept.id} style={{ border: "1px solid red", margin: "5px", padding: "5px" }}>
              <strong>{dept.name}</strong>

              {/* Courses */}
              <ul>
              {dept.courses.map((course, index) => (
              <li key={index}>{course}</li>
                ))}
              </ul>
            </div>
          ))}
        </div>
      ))}
    </div>
  );
}


export default CollegeList;
