import React, { useState } from 'react';
import "./SpecialHoursForm.css"
import moment from 'moment';
import specialhours from './fixtures/SpecialHours';

const SpecialHoursForm = (props) => {
  const [formData, setFormData] = useState({
    title: '',
    description: '',
    startDate: '',
    endDate: '',
    startTime : '',
    endTime:'',
    isActive: true,
  });

  const [error, setError] = useState("")


  console.log("special hours : ", specialhours)
  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setFormData({
      ...formData,
      [name]: type === 'checkbox' ? checked : value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
  
    const startDate = moment(formData.startDate).format("YYYY-MM-DD")
    const startTime = formData.startTime
    const endDate = moment(formData.endDate).format("YYYY-MM-DD")
    const endTime = formData.endTime
   

    const isdateRageCorrect = moment(endDate).isSameOrAfter(startDate, "day")

    const isTimeRangeCorrect = moment(formData.endTime,"HH:mm").isSameOrAfter(moment(formData.startTime,"HH:mm"))

   
    console.log("form data times" ,formData.startTime, formData.endTime)
    console.log("time range error check" ,isTimeRangeCorrect)
    if(!isdateRageCorrect){
      setError("Start Date must be before End Date")
      return
    }
    if(!isTimeRangeCorrect){
      setError("Start Time must be before End Time")
      return
    }
    

    specialhours.push({
      ...formData,
      startDate,
      startTime,
      endDate,
      endTime

    })

    setFormData({
      title: '',
      description: '',
      startDate: '',
      endDate: '',
      startTime : '',
      endTime:'',
      isActive: true,
    })
    setError("")
  };

  return (
    <form className="custom-form" onSubmit={handleSubmit}>
      <div className="form-group">
        {error !== "" &&<p style={{color : "red", fontWeight : "bolder"}}>{error}</p>}
      </div>
      <div className="form-group">
        <label>Title</label>
        <input
          type="text"
          name="title"
          value={formData.title}
          onChange={handleChange}
          className="form-input"
        />
      </div>

     
      <div className="form-group">
        <label>Description</label>
        <input
          type="text"
          name="description"
          value={formData.description}
          onChange={handleChange}
          className="form-input"
        />
      </div>

      <div className="form-group">
        <label>Start Date</label>
        <input
          type="date"
          name="startDate"
          value={formData.startDate}
          onChange={handleChange}
          required
          className="form-input"
        />
        <label>Start Time</label>
        <input
          type="time"
          name="startTime"
          value={formData.startTime}
          onChange={handleChange}
          required
          className="form-input"
        />
      </div>

      <div className="form-group">
        <label>End Date</label>
        <input
          type="date"
          name="endDate"
          value={formData.endDate}
          required
          onChange={handleChange}
          className="form-input"
        />
        <label>End Time</label>
        <input
          type="time"
          name="endTime"
          value={formData.endTime}
          required
          onChange={handleChange}
          className="form-input"
        />
      </div>

      <div className="form-group checkbox-group">
        <label>
          <input
            type="checkbox"
            name="isActive"
            checked={formData.isActive}
            onChange={handleChange}
          />
          IsActive
        </label>
      </div>

      <button type="submit" className="submit-button">Submit</button>
    </form>
  );
};

export default SpecialHoursForm;
