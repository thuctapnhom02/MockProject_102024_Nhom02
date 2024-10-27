import { useState } from 'react'
import LoginFake from './LoginFake'
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import RMSPage from './RMPage';
import HomePage from './Home';
import Complant from './Complant';
import ComplantDetail from './ComplantDetail';
import Staff from './Staff';


function App() {  
    

    return (
      <Router>
        <Routes>
          <Route path="/Login" element={<LoginFake></LoginFake>}/>
          <Route path="/RMP" element={<RMSPage></RMSPage>}/>
          <Route path="/complant" element={<Complant></Complant>} />
          <Route path="/complantDetail/:id" element={<ComplantDetail></ComplantDetail>} />
          <Route path="/staff" element={<Staff></Staff>} />
          <Route path="*" element={<HomePage></HomePage>} />
        </Routes>
      </Router>
    );
}

export default App
