import React from 'react'
import moment from 'moment'
import servicehours from './fixtures/Servicehours'
import "./ServiceHoursDetails.css"

const ServiceHoursDetails = (props) => {

    const { serviceHours } = props
    const {isSpecialHours , startTime, endTime} = serviceHours

    console.log("schedule timing : ", moment(startTime, "HH:mm:sss").format('hh:mm A'), endTime)

    return(
        <div >
            { isSpecialHours &&
                <div className='container-shd'>
                    <h4 className='schedule-sh'>Special Hours</h4>
                    <p className='schedule-sh'>{`${moment(startTime, "HH:mm:sss").format('hh:mm A')} ${endTime && endTime !== "" && "- " + moment(endTime, "HH:mm:sss").format('hh:mm A')}`}</p>
                </div>
            }
            {   
                servicehours.map((sh)=>{
                    
                    return (
                       <div className='container-shd'>
                       
                            <h4 className='schedule'>{`${sh.startDay} ${sh.endDay && sh.endDay !== "" && "- " + sh.endDay}`}</h4>
                            <p className='schedule'>{`${moment(sh.startTime, "HH:mm:sss").format('hh:mm A')} ${sh.endTime && sh.endTime !== "" && "- " + moment(sh.endTime, "HH:mm:sss").format('hh:mm A')}`}</p>
            
                      
                        </div>)
                })
            }
            
        </div>
    )

}

export default ServiceHoursDetails