import React from "react";

function List() {
    const students = [
        {
            company: 'Alfreds Futterkiste',
            contact: 'Maria Anders',
            country: 'Germany'
        },
        {
            company: 'Centro comercial Moctezuma',
            contact: 'Francisco Chang',
            country: 'Mexico'
        },
        {
            company: 'Ernst Handel',
            contact: 'Roland Mendel',
            country: 'Austria'
        },
        {
            company: 'Island Trading',
            contact: 'Helen Bennett',
            country: 'UK'
        },
        {
            company: 'Laughing Bacchus Winecellars',
            contact: 'Yoshi Tannamuri',
            country: 'Canada'
        },
        {
            company: 'Magazzini Alimentari Riuniti',
            contact: 'Giovanni Rovelli',
            country: 'Italy'
        }
    ];

    return (
        <div>
            <table>
                <thead>
                <tr>
                    <th>stt</th>
                    <th>Company</th>
                    <th>Name</th>
                    <th>Country</th>
                </tr>
                </thead>
                <tbody>
                {students.map(item => {
                    if (item.country === "Italy") {
                        let index = 0;
                        return (
                            <tr key={index + 1}>
                                <td>{index}</td>
                                <td>{item.contact}</td>
                                <td>{item.company}</td>
                                <td>{item.company}</td>
                            </tr>)
                    }
                })}
                </tbody>
            </table>
        </div>
    )
}

export default List;
