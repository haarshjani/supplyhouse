import React, { useEffect, useState } from "react";
import moment from "moment";

import { MailOutlined, MessageOutlined, PhoneOutlined, WechatOutlined } from "@ant-design/icons"
import "./CommunicationDetails.css"

const Communications = [
    {
        medium : "Call",
        details : "888-551-77600",
        icon : "phone"
    },
    {
        medium : "Text",
        details : "888-551-77600",
        icon : "Message"
    },
    {
        medium : "Live Chat",
        details : "",
        icon : "chat"
    },
    {
        medium : "Email",
        details : "",
        icon : "mail"
    }
]
const CommunicationDetails = (props) => {

    const [isServiceAvailable, setIsServiceAvable] = useState(false)


    useEffect(() => {

    const serviceHours = props.serviceHours

    

    let isAvailable;
    if(Object.entries(serviceHours).length !== 0){
      const time = moment()
      const startTime = moment(serviceHours.startTime,"hh:mm")
      const endTime = moment(serviceHours.endTime , "hh:mm")

      isAvailable = time.isBetween(startTime, endTime)

    }
    console.log("Service details",serviceHours, isAvailable)

    setIsServiceAvable(isAvailable)

    },[props.serviceHours])

    return(
        <div className="container-column">
        {
            Communications.map((comm) =>{

                const iconStyle = {fontSize : "35px" ,color: `${isServiceAvailable || comm.medium === "Email" ? "black" : "lightgrey"}` , padding:"10px  20px 10px 0px"}

                return( <div className="container-comm">
                    { comm.medium === "Call" && <PhoneOutlined rotate={90} style={iconStyle}/>}
                    { comm.medium === "Text" && <MessageOutlined  style={iconStyle}/>}
                    { comm.medium === "Live Chat" && <WechatOutlined style={iconStyle}/>}
                    { comm.medium === "Email" && <MailOutlined style={iconStyle}/>}
                    <span className="comm-details-outer">
                        <span className={"comm-details"}>
                            <h3 className={isServiceAvailable  || comm.medium === "Email" ? "title-comm" : "title-comm-disable"}>{comm.medium}</h3>
                            <p style={{marginLeft : "7px"}}>{comm.details}</p>
                        </span>
                         <span className="comm-details">
                            <p style={{display:"list-item", color : `${isServiceAvailable || comm.medium === "Email" ? "green" : "lightgrey"}`, fontSize:"1.5rem", width : "15px", listStylePosition : "inside",}}></p>
                            <p>{comm.medium === "Email" ? "Response by sun" : 'Available ' + moment().format("h:mm A")}</p>
                        </span>
                    
                    </span>
                </div>)
            })
        }
     </div>  
    )

}

export default CommunicationDetails