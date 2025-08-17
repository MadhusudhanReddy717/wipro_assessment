//Class Component
import React from "react";

class Products extends React.Component //packagename.classname
{
    constructor(props) 
    {
        super(props);
        console.log(this.props);
     }
     render() //output of class component
     {
        return <div>
        <h2>Product Details...</h2>
        <p>
        <label>Product ID : <b>{this.props.pid}</b></label>
        </p>
        <p>
            <label>Product Name : <b>{this.props.pname}</b></label>
        </p>
        <p>
            <label>Product Cost : <b>{this.props.pcost}</b></label>
        </p>
        <Warehouses wid1={this.props.wid111} wname2={this.props.wname111} wlocation3={this.props.wlocation111} />
        </div>;
      }
}


class Warehouses extends React.Component 
{
    render() {
        return <div>
        <h2>Warehouses Details...</h2>
        <p>
            <label>WareHouse ID : <b>{this.props.wid1}</b></label>
        </p>
        <p>
            <label>WareHouse Name : <b>{this.props.wname2}</b></label>
        </p>
        <p>
            <label>Location : <b>{this.props.wlocation3}</b></label>
        </p>
    </div>;
    }
}

export default Products;