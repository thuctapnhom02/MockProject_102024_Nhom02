import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './component/App'
import './assets/css/index.css'
import {
  createBrowserRouter,
  RouterProvider,
  Route,
  Link,
} from "react-router-dom";
import Test_api from './component/Test_api';

const router = createBrowserRouter([
  {
    path: "/test_api",
    element: (
      <div>
        <Test_api></Test_api>
      </div>
    ),
  },
  {
    path: "/",
    element: (
      <div>
        <App></App>
      </div>
    ),
  },

]);




createRoot(document.getElementById("root")).render(
  <RouterProvider router={router} />
);
// createRoot(document.getElementById('root')).render(
//   <StrictMode>
//     <App />
//   </StrictMode>
// )

