//Arrow Functional component
const CreditPoints = (Info) => {
    return <div><p>Points-1 : <b>{Info.f_pt1}</b></p>
        <p>Points-2 : <b>{Info.f_pt2}</b></p>
    </div>;
}
//one functional component reused by another  functional component

const Customerinfo = (data12) => {
    return (<div><p>Name : {data12.cusname}</p>
        <p>Location : {data12.cusloc}</p>
        <CreditPoints f_pt1={data12.f_pt1} f_pt2={data12.f_pt2} />
         </div>);
}
/*
Every module is said to have at most one default export. I
*/
export default Customerinfo;
