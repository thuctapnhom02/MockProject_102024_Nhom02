import { useState } from 'react'
import LoginFake from './LoginFake'
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import RMSPage from './RMPage';
import HomePage from './Home';


function App() {  
    

    return (
      <Router>
        <Routes>
          <Route path="/Login" element={<LoginFake></LoginFake>}/>
          <Route path="/RMP" element={<RMSPage></RMSPage>}/>
          <Route path="*" element={<HomePage></HomePage>} />
        </Routes>
      </Router>
    );
}

export default App
