import { useEffect, useState } from 'react'
import moment from 'moment'
import reactLogo from './assets/react.svg'
import personLogo from './assets/ME_photo_2.png'
import viteLogo from '/vite.svg'
import './servicehours.css'
import CommunicationDetails from './CommunicationDetails'
import ServiceHoursDetails from './ServiceHoursDetails'
import specialhours from './fixtures/SpecialHours'
import servicehours from './fixtures/Servicehours'
import SpecialHoursForm from './SpecialHoursForm'

function App() {
  const [serviceHours, setServiceHours] = useState({})

  useEffect(() => {
    const specialHour = specialhours.find((sp) =>{
    
      return  moment().isSame(sp.startDate,'day') || moment().isSame(sp.endDate, 'day') || moment().isBetween(sp.startDate,sp.endDate)
      })

      const serviceHours = servicehours.find((sh) => {

          const today = moment().weekday()
          const startDay = moment().day(sh.startDay).weekday()
          const endDay = moment().day(sh.endDay).weekday()


          return today >= startDay || today <= endDay
      })

      setServiceHours(specialHour ? {...specialHour, isSpecialHours : true} : {...serviceHours, isSpecialHours : false})
    
  },[])
  return(
      
      <div className='container'>
        <SpecialHoursForm />
        <div className='contactus'>
          <div className='card'>
            <img src={personLogo} className='rounded-icon'/>
            <h3 className='title'>{serviceHours.title || serviceHours.title !== "" ? serviceHours.title : "Question" }</h3>
            <text>{serviceHours.description || serviceHours.description!== "" ? serviceHours.description : "Our customer Support will be available as per schedule"}</text>
          </div>
          <div className='card-middle'>
            <CommunicationDetails serviceHours={serviceHours}/>

          </div>
          <div className='card-bottom'>
            <ServiceHoursDetails  serviceHours={serviceHours}/>
          </div>
        </div>
        
      </div>
    
  )
}

export default App
