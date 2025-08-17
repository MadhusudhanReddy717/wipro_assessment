import { Component } from "react";

class ClassDemo1 extends Component
{
    render() 
    {
        const headingStyle = {
            color: 'blue',
            textAlign: 'center',
        };

        const paragraphStyle = {
            color: 'green',
            fontSize: '18px',
        };

        return (
            <div>
                <h1 style={headingStyle} >Welcome to React!</h1>
                <p style={paragraphStyle}>This is a simple class component.</p>
            </div>
        );
    }
}

export default ClassDemo1;